package druidsurv.cards.monkeys.magick;

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

public class ChainLightningDruid extends AbstractEasyCard {
    public final static String ID = makeID("ChainLightningDruid");
    // intellij stuff attack, enemy, basic, 6, 3,  , , ,

    public ChainLightningDruid() {
        super(ID, 3, CardType.ATTACK, CardRarity.RARE, CardTarget.ALL_ENEMY, CharacterFile.Enums.NEMDRUID_COLOR, "ThunderDruid_CardArt");
        baseDamage = 20;
        tags.add(druidsurv.cards.cardvars.CardTags.MONKEY);
        this.setCardBack(cardSubType.MONKEY);
        setOrbTexture("druidsurvResources/images/512/r_mox.png", "druidsurvResources/images/1024/r_mox.png");
    }

    @Override
    public boolean canPlay(AbstractCard card) {
        AbstractEasyCard me = this;
        boolean hasMyGMox = false;
        boolean hasMyRMox = false;
        for (int i = 0; i < p().orbs.size(); i++) {
            if (p().orbs.get(i) instanceof MoxOrb)
            {
                if (((MoxOrb)p().orbs.get(i)).GreenAmount > 0)
                {
                    hasMyGMox = true;
                }
            }
            if (p().orbs.get(i) instanceof MoxOrb)
            {
                if (((MoxOrb)p().orbs.get(i)).RubyAmount > 0)
                {
                    hasMyRMox = true;
                }
            }
        }
        if (Objects.equals(card.cardID, this.cardID) ) { return hasMyGMox && hasMyRMox && super.canPlay(card); }
        return super.canPlay(card);
    }
    public void use(AbstractPlayer p, AbstractMonster m)
    {
        addToTop(new JuggernautDamageAction(null, new DamageInfo(p, damage), this.uuid, false));
    }

    @Override
    public void upp() {
        upgradeDamage(9);
    }
}