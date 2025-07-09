package druidsurv.cards.bloons;

import com.evacipated.cardcrawl.mod.stslib.fields.cards.AbstractCard.PersistFields;
import com.evacipated.cardcrawl.mod.stslib.variables.ExhaustiveVariable;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.relics.PrismaticShard;
import druidsurv.cards.AbstractEasyCard;
import druidsurv.powers.bloons.BasicBloonPower;

import static druidsurv.ModFile.makeID;

public class CeramicBloon extends AbstractEasyCard {
    public final static String ID = makeID("CeramicBloon");
    // intellij stuff skill, self, basic, , ,  5, 3, ,

    public CeramicBloon() {
        super(ID, 1, CardType.ATTACK, CardRarity.UNCOMMON, CardTarget.SELF_AND_ENEMY, "CeramicBloon_CardArt");
        //baseDamage = 48;
        baseBlock = 10;
        tags.add(druidsurv.cards.cardvars.CardTags.BLOON);
        PersistFields.setBaseValue(this, 2);
        this.setCardBack(cardSubType.BLOON);
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot((AbstractGameAction)new ApplyPowerAction(m, p, new BasicBloonPower(m, 2, damage, "Ceramic Bloon"), damage, true, AbstractGameAction.AttackEffect.NONE));
        bloonBlck();
    }

    @Override
    public void upp()
    {
        PersistFields.upgrade(this, 1);
        //ExhaustiveVariable.upgrade(this, 1);
    }
}