package druidsurv.cards.monkeys.magick;

import com.evacipated.cardcrawl.mod.stslib.fields.cards.AbstractCard.PurgeField;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import druidsurv.CharacterFile;
import druidsurv.actions.JuggernautDamageAction;
import druidsurv.cards.AbstractEasyCard;
import druidsurv.orbs.mox.MoxOrb;

import java.util.Objects;

import static druidsurv.ModFile.makeID;
import static druidsurv.util.Wiz.p;

public class Juggernaut extends AbstractEasyCard {
    public final static String ID = makeID("Juggernaut");
    // intellij stuff attack, enemy, basic, 6, 3,  , , ,

    public Juggernaut() {
        super(ID, 2, CardType.ATTACK, CardRarity.UNCOMMON, CardTarget.ALL_ENEMY, CharacterFile.Enums.NEMDRUID_COLOR, "SpikeOPult_CardArt");
        baseDamage = 10;
        tags.add(druidsurv.cards.cardvars.CardTags.MONKEY);
        this.setCardBack(cardSubType.MONKEY);
    }
    @Override
    public boolean canPlay(AbstractCard card) {
        AbstractEasyCard me = this;
        boolean hasMyMox = false;
        for (int i = 0; i < p().orbs.size(); i++) {
            if (p().orbs.get(i) instanceof MoxOrb)
            {
                if (((MoxOrb)p().orbs.get(i)).RubyAmount > 0)
                {
                    hasMyMox = true;
                }
            }
        }
        if (Objects.equals(card.cardID, this.cardID) ) { return hasMyMox && super.canPlay(card); }
        return super.canPlay(card);
    }

    public void use(AbstractPlayer p, AbstractMonster m)
    {
        addToTop(new JuggernautDamageAction(null, new DamageInfo(p, damage), this.uuid, true));
    }

    @Override
    public void upp() {
        upgradeDamage(9);
    }
}