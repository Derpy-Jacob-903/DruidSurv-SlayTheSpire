package druidsurv.cards.bloons;

import com.evacipated.cardcrawl.mod.stslib.fields.cards.AbstractCard.PersistFields;
import com.evacipated.cardcrawl.mod.stslib.variables.ExhaustiveVariable;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import druidsurv.cards.AbstractEasyCard;
import druidsurv.powers.bloons.DoubleBloonPower;

import static druidsurv.ModFile.makeID;

public class DoubleRedBloon extends AbstractEasyCard {
    public final static String ID = makeID("DoubleRedBloon");
    // intellij stuff skill, self, basic, , ,  5, 3, ,

    public DoubleRedBloon() {
        super(ID, 1, CardType.ATTACK, CardRarity.UNCOMMON, CardTarget.SELF_AND_ENEMY, "DoubleRedBloon_CardArt");
        baseDamage = 4;
        baseBlock = 3;
        tags.add(druidsurv.cards.cardvars.CardTags.BLOON);
        tags.add(druidsurv.cards.cardvars.CardTags.BASIC);
        PersistFields.setBaseValue(this, 2);
        ExhaustiveVariable.setBaseValue(this, 2);
        this.setCardBack(cardSubType.BLOON);
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot((AbstractGameAction)new ApplyPowerAction(m, p, new DoubleBloonPower(m, 1, damage, "Double Red Bloon"), 1, true, AbstractGameAction.AttackEffect.NONE));
        bloonBlck();
    }

    @Override
    public void upp() {
        upgradeBlock(3);
    }
}